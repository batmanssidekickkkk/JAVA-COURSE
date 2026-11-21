class PolyAnimal {
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

class PolyDog extends PolyAnimal {
    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
}

class PolyCat extends PolyAnimal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

class PolyCow extends PolyAnimal {
    @Override
    public void makeSound() {
        System.out.println("Moo!");
    }
}

public class PolymorphisimDemo {
    public static void main(String[] args) {
        PolyAnimal[] myAnimals = new PolyAnimal[3];

        myAnimals[0] = new PolyDog();
        myAnimals[1] = new PolyCat();
        myAnimals[2] = new PolyCow();

        System.out.println("=== ANIMAL SOUNDS ===");
        for (int i = 0; i < myAnimals.length; i++) {
            myAnimals[i].makeSound();
        }
    }
}