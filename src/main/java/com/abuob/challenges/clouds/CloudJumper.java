package com.abuob.challenges.clouds;

/*

Emma is playing a new mobile game that starts with consecutively numbered clouds.
Some of the clouds are thunderheads and others are cumulus.
She can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus 1 or 2.

She must avoid the thunderheads. Determine the minimum number of jumps it will take Emma to jump from her starting postion to the last cloud. It is always possible to win the game.

For each game, Emma will get an array of clouds numbered if they are safe or if they must be avoided.
For example, C=[0,1,0,0,0,1,0] indexed from 0 to 6.
The number on each cloud is its index in the list so she must avoid the clouds at indexes 1 and 5.
She could follow the following two paths: 0-2-4-6 or 0-2-3-4-6 . The first path takes 3 jumps while
the second takes 4.

Function Description

jumpingOnClouds has the following parameter(s):

c: an array of binary integers
It should return the minimum number of jumps required, as an integer.

 */
public class CloudJumper {

    public static int jumpingOnClouds(int[] array) {
        int numJumps = 0;
        int arraySize = array.length;

        Integer next;
        Integer ahead;

        for (int i = 0; i < arraySize; ) {
            next = i + 1 <= arraySize - 1 ? array[i + 1] : null;
            ahead = i + 2 <= arraySize - 1 ? array[i + 2] : null;

            if (next == null && ahead == null) {
                break;
            }

            if (ahead != null && ahead == 0) {
                numJumps++;
                i = i + 2;
            } else if (next != null && next == 0) {
                numJumps++;
                i = i + 1;
            }
        }
        return numJumps;
    }
}
