package com.abuob.challenges.routing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*-
 * PathRouter.java
 *
 * Approach:
 * Parse URL path and endpoint pairs and put into RouteNode tree structure.
 * The RootNode contains a reference to its parent, a map of child nodes with the next token
 * in the path a a key and reference to wildcard child. This is done so we prefer exact match
 * and then use the wildcard as fallback if present. Using this structure, the path to endpoint resolution
 * depends only on the number of components in the path. Recursive methods are implemented to construct the RootNode
 * tree structure and then to traverse it an attempt to resolve the path to an endpoint.
 *
 * NOTE:An input line beginning with the character '#' will toggle between config and path resolution mode
 */
public class PathRouter {

    private static final String WILDCARD_TOKEN = "X";

    public static void main(String[] args) {

        RouteNode rootNode = new RouteNode();

        boolean isResolvePathMode = false;

        //Read each line and add to router or resolve endpoint
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String nextLine = input.nextLine();

            //Switch from adding configuration to resolving URLs to endpoints
            if (nextLine.startsWith("#")) {
                //System.out.println("Switching input mode");
                isResolvePathMode = !isResolvePathMode;
                continue;
            }
            //Process each line depending on the mode
            Scanner lineParser = new Scanner(nextLine);
            String path;
            String endpoint;

            if (!isResolvePathMode) {
                path = lineParser.next();
                endpoint = lineParser.next();
                addPathEndpointConfiguration(path, endpoint, rootNode);
                //printTree(rootNode);
            } else {
                path = lineParser.next();
                endpoint = resolvePathToEndpoint(path, rootNode);
                System.out.println(path + " " + endpoint);
            }
            lineParser.close();
        }
        input.close();
    }

    private static void addPathEndpointConfiguration(final String inputPath, final String endpoint, final RouteNode routeNode) {

        //Remove the trailing '/' if the user provides it
        String cleanPath = inputPath.endsWith("/") ? inputPath.substring(0, inputPath.length() - 1) : inputPath;

        //Remove the beginning "/" to find the path
        String pathToProcess = cleanPath.substring(cleanPath.indexOf("/") + 1);

        String token;
        String subPath;

        // token - current path component being processed
        // subPath - remaining path to process
        if (pathToProcess.indexOf(("/")) == -1) {
            token = pathToProcess;
            subPath = "";
        } else {
            token = pathToProcess.substring(0, pathToProcess.indexOf("/"));
            subPath = pathToProcess.substring(pathToProcess.indexOf("/"));
        }

        //Terminate the recursion - Add the endpoint when we arrive at the end of the url path
        if (token.equals("")) {
            //System.out.println("Added endpoint:" + endpoint);
            routeNode.setEndpoint(endpoint);
            return;
        }

        RouteNode addedNode;

        //Use existing node or add a new node to resolve the subPath with recursive call
        if (token.equals(WILDCARD_TOKEN)) {
            //System.out.println("wildcard - token:" + token + " subPath:" + subPath);

            //Existing wildcard node
            if (routeNode.hasAnyMatchChildNode()) {
                addedNode = routeNode.getAnyMatchChildNode();
            } else {
                addedNode = new RouteNode();
                addedNode.setPath("/" + token);
                addedNode.setParent(routeNode);
            }
            routeNode.setAnyMatchChildNode(addedNode);

        } else {
            //System.out.println("exactMatch - token:" + token + " subPath:" + subPath);

            //Existing child node
            if (routeNode.getChildNodes().containsKey(token)) {
                addedNode = routeNode.getChildNodes().get(token);
            } else {
                addedNode = new RouteNode();
                addedNode.setPath("/" + token);
                addedNode.setParent(routeNode);
            }
            routeNode.addChildNode(token, addedNode);
        }

        //System.out.println("SP:"+ subPath + " endpoint:" + endpoint);

        //When adding a wildcard and there are exacts matches, add the subPath to all existing child nodes
        if (token.equals(WILDCARD_TOKEN) && routeNode.hasChildNodes()) {
            for (RouteNode childNode : routeNode.getChildNodes().values()) {
                addPathEndpointConfiguration(subPath, endpoint, childNode);
            }
        }

        //Recursive call with the added node and the new truncated subPath
        addPathEndpointConfiguration(subPath, endpoint, addedNode);
    }

    private static String resolvePathToEndpoint(final String fullPath, final RouteNode routeNode) {

        //Remove the beginning "/" to find the path
        String pathToProcess = fullPath.substring(fullPath.indexOf("/") + 1);

        String token;
        String subPath;

        // token - current path component being processed
        // subPath - remaining path to process
        if (pathToProcess.indexOf(("/")) == -1) {
            token = pathToProcess;
            subPath = "";
        } else {
            token = pathToProcess.substring(0, pathToProcess.indexOf("/"));
            subPath = pathToProcess.substring(pathToProcess.indexOf("/"));
        }

        //End of the path string, resolve to endpoint or return 404
        if (token.equals("")) {
            String resolvedEndpoint = !routeNode.getEndpoint().equals("") ? routeNode.getEndpoint() : "404";
            //System.out.println("path:" + fullPath + " resolvedEndpoint:" + resolvedEndpoint);
            return resolvedEndpoint;
        }

        RouteNode childNodeForToken = routeNode.getChildNodes().get(token);
        //Exact match
        if (childNodeForToken != null) {
            //System.out.println("exactMatch - token:" + token +" subPath:" + subPath);
            return resolvePathToEndpoint(subPath, childNodeForToken);
        }

        //Wildcard match
        if (routeNode.hasAnyMatchChildNode()) {
            //System.out.println("wildcardMatch - token:" + token+" subPath:" + subPath);
            return resolvePathToEndpoint(subPath, routeNode.getAnyMatchChildNode());
        }

        //No exact or wildcard match can be found
        //System.out.println("no match - token:" + token);
        return "404";
    }

    //TEST OUTPUT METHOD
    private static void printTree(RouteNode routeNode) {

        System.out.println("PATH:" + routeNode.getPath() +
                " numChildNodes:" + routeNode.getChildNodes().size() +
                " hasAnyMatch:" + routeNode.hasAnyMatchChildNode() +
                " endpoint:" + routeNode.getEndpoint());

        if (routeNode.hasAnyMatchChildNode()) {
            printTree(routeNode.getAnyMatchChildNode());
        } else {
            System.out.println("PATH:" + routeNode.getPath() + " NO WILD MATCH NODE");
        }

        if (!routeNode.getChildNodes().isEmpty()) {
            for (String key : routeNode.getChildNodes().keySet()) {
                System.out.println("PATH:" + routeNode.getPath() + " key:" + key);
                printTree(routeNode.getChildNodes().get(key));
            }
        } else {
            System.out.println("PATH:" + routeNode.getPath() + " NO CHILD MATCH NODE");
        }
    }
}

class RouteNode {
    private RouteNode parent;

    private String path = "/";
    private String endpoint = "";

    private RouteNode anyMatchChildNode;
    private Map<String, RouteNode> childNodes = new HashMap<>();

    public RouteNode() {
    }

    public RouteNode getParent() {
        return parent;
    }

    public void setParent(RouteNode parent) {
        this.parent = parent;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public RouteNode getAnyMatchChildNode() {
        return anyMatchChildNode;
    }

    public void setAnyMatchChildNode(RouteNode anyMatchChildNode) {
        this.anyMatchChildNode = anyMatchChildNode;
    }

    public boolean hasAnyMatchChildNode() {
        return anyMatchChildNode != null;
    }

    public Map<String, RouteNode> getChildNodes() {
        return childNodes;
    }

    public boolean hasChildNodes() {
        return !childNodes.isEmpty();
    }

    public void addChildNode(String token, RouteNode routeNode) {
        childNodes.put(token, routeNode);
    }
}
