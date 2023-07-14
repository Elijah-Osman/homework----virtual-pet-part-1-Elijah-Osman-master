package virtual_pet;

import java.util.Random;
import java.util.Scanner;

class VirtualPet {
    private String name;
    private int hunger;
    private int boredom;
    private int energy;

    public VirtualPet(String name) {
        this.name = name;
        this.hunger = 50;
        this.boredom = 50;
        this.energy = 50;
    }

    public void feed() {
        hunger -= 20;
        energy += 10;
    }

    public void play() {
        boredom -= 30;
        energy -= 20;
    }

    public void sleep() {
        energy += 40;
    }

    public void tick() {
        hunger += 10;
        boredom += 10;
        energy -= 10;

        // Ensure attributes stay within valid range
        hunger = Math.min(hunger, 100);
        boredom = Math.min(boredom, 100);
        energy = Math.min(energy, 100);
        hunger = Math.max(hunger, 0);
        boredom = Math.max(boredom, 0);
        energy = Math.max(energy, 0);

        // Pet takes care of its own needs randomly
        Random random = new Random();
        if (random.nextDouble() < 0.5) {
            if (hunger > 70) {
                feed();
            } else if (boredom > 70) {
                play();
            } else if (energy < 30) {
                sleep();
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    public int getBoredom() {
        return boredom;
    }

    public int getEnergy() {
        return energy;
    }
}

public class VirtualPetApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VirtualPet pet = new VirtualPet("Fido");

        System.out.println("Welcome to Virtual Pet!");
        System.out.println("Pet's initial stats:");
        System.out.println("Name: " + pet.getName());
        System.out.println("Hunger: " + pet.getHunger());
        System.out.println("Boredom: " + pet.getBoredom());
        System.out.println("Energy: " + pet.getEnergy());

        while (true) {
            pet.tick();
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Feed the pet");
            System.out.println("2. Play with the pet");
            System.out.println("3. Let the pet sleep");
            System.out.println("4. Quit");

            System.out.print("Enter your choice (1-4): ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                pet.feed();
                System.out.println("You fed the pet.");
            } else if (choice.equals("2")) {
                pet.play();
                System.out.println("You played with the pet.");
            } else if (choice.equals("3")) {
                pet.sleep();
                System.out.println("You let the pet sleep.");
            } else if (choice.equals("4")) {
                System.out.println("Thanks for playing! Goodbye.");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }

            System.out.println("Pet's current stats:");
            System.out.println("Hunger: " + pet.getHunger());
            System.out.println("Boredom: " + pet.getBoredom());
            System.out.println("Energy: " + pet.getEnergy());
        }
    }
}

