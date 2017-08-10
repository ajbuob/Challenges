package com.abuob.challenges.problem2;

import com.abuob.challenges.problem2.enums.Direction;

import java.util.ArrayList;
import java.util.List;

public final class Animator {

    //Private constructor to prevent object instantiation
    private Animator() {
    }

    /**
     * Public utility method to provide particle history based on each particle in
     * the initialization string having the same speed.
     *
     * @param speed the speed of each particle
     * @param init  the initialization string containing 'L','R', or '.' to indicate the presence of a particle or not
     *              and the direction in which it will move over time.
     * @return an list of strings in which each successive element shows the occupied locations at each time step
     * @throws IllegalArgumentException if the speed is negative or the init string is null or empty
     */
    public static List<String> animate(int speed, String init) {

        if (speed < 0 || init == null || init.isEmpty()) {
            throw new IllegalArgumentException("Speed is negative or initial chamber condition is empty. " +
                    "Please check the input and try again");
        }

        int time = 0;
        int chamberSize = init.length();
        List<Particle> particles = initializeParticles(speed, init);
        List<Integer> particlePositions;
        List<String> chamberHistory = new ArrayList<>();

        while (true) {
            //Calculate the current position of all the particles at the given time
            particlePositions = calculateParticlePostitionsAtTime(particles, time);
            //Draw the current chamber and add it to the history
            chamberHistory.add(drawCurrentChamber(particlePositions, chamberSize));

            //No need to continue if all particles have exited the chamber
            if (!isParticleInChamber(particlePositions, chamberSize)) {
                break;
            }
            time++;
        }
        return chamberHistory;
    }

    /**
     * Private utility method to initialize the list of particles
     *
     * @param speed the speed of each particle
     * @param init  the initialization string
     * @return a list of particles
     */
    private static List<Particle> initializeParticles(int speed, String init) {
        int chamberSize = init.length();
        List<Particle> particles = new ArrayList<>();
        Direction direction;

        //Iterate over init string and add each particle to the list.
        for (int i = 0; i < chamberSize; i++) {
            char c = init.charAt(i);
            if (c != '.') {
                direction = Direction.findByAbbreviation(c);
                particles.add(new Particle(direction, i, speed));
            }
        }
        return particles;
    }

    /**
     * Private utility method to calculate the current position of each particle at a given time.
     *
     * @param particles the list of particles which the current position will be calculated
     * @param time      the time at which to calcualte the position of the particles
     * @return a list of integers containing the position of each particle
     */
    private static List<Integer> calculateParticlePostitionsAtTime(List<Particle> particles, int time) {
        List<Integer> positions = new ArrayList<>();
        for (Particle p : particles) {
            positions.add(p.getPositionOverTime(time));
        }
        return positions;
    }

    /**
     * Private utility method to display the current state of the chamber
     *
     * @param positions   the list of positions for each particle
     * @param chamberSize the length of the chamber
     * @return a string representation of the chamber
     */
    private static String drawCurrentChamber(List<Integer> positions, int chamberSize) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chamberSize; i++) {
            if (positions.contains(i)) {
                builder.append("X");
            } else {
                builder.append(".");
            }
        }
        return builder.toString();
    }

    /**
     * Private utility method to determine if any particles are in the chamber
     *
     * @param positions   the list of positions for each particle
     * @param chamberSize the length of the chamber
     * @return true if any particles are in the chamber, false otherwise
     */
    private static boolean isParticleInChamber(List<Integer> positions, int chamberSize) {
        for (Integer p : positions) {
            //Particle will be in chamber if the position is in [0,chamberSize-1]
            //inclusive on both ends as it is zero based.
            if (0 <= p && p <= chamberSize - 1) {
                return true;
            }
        }
        return false;
    }
}