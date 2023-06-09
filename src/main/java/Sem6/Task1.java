package Sem6;

// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// Создать множество ноутбуков (Set).
// Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации
// и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map или в Сет.
// Например:
// “Введите цифру, соответствующую необходимому критерию:
// 1 - цвет
// 2 - бренд

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Task1 {
    public static void main(String[] args) {
        laptop laptop1 = new laptop("Lenovo", "ThinkBook 15 G3 ACL", "gray", "16", "512", "AMD Ryzen 7 5700U", "15.6");
        laptop laptop2 = new laptop("MSI", "Prestige 14 Evo A12M-262RU", "blue", "16", "512", "Intel Core i7-1280P", "14");
        laptop laptop3 = new laptop("Acer", "Nitro 5 AN515-58-74XD", "black", "16", "512", "Intel Core i7-12700H", "15.6");
        laptop laptop4 = new laptop("HP", "ProBook 450 G8", "silver", "16", "512", "Intel Core i7-1165G7", "15.6");
        laptop laptop5 = new laptop("MSI", "Raider GE67HX 12UHS-099RU", "gray", "32", "2000", "Intel Core i9-12900HX", "15.6");
        laptop laptop6 = new laptop("HP", "255 G8", "gray", "8", "512", "AMD Ryzen 5 5500U", "15.6");
        laptop laptop7 = new laptop("Dell", "XPS 17 9720", "silver", "32", "1000", "Intel Core i7 12700H", "17");
        laptop laptop8 = new laptop("Lenovo", "ThinkBook 14 G2 ITL", "gray", "8", "256", "Intel Core i5-1135G7", "14");
        laptop laptop9 = new laptop("MSI", "Summit E13 Flip Evo A12MT-060RU", "black", "16", "1000", "Intel Core i5-1240P", "13,4");
        laptop laptop10 = new laptop("ASUS", "TUF Gaming A15 FA507RM-HN054", "gray", "8", "512", "AMD Ryzen 7 6800H", "15.6");

        HashSet<laptop> laptops = new HashSet<laptop>(
                Arrays.asList(laptop1, laptop2, laptop3, laptop4, laptop5, laptop6, laptop7, laptop8, laptop9, laptop10));

        Scanner scanner = new Scanner(System.in, "utf-8");

        System.out.println();
        System.out.println("Добро пожаловать в сеть магазинов цифровой и бытовой техники");

        boolean filter = true;
        while (filter) {
            System.out.println(
                    "Фильтр по производителю, введите - 1\n" +
                            "Фильтр по цвету, введите - 2\n" +
                            "Фильтр по объёму оперативной памяти, введите - 3\n" +
                            "Фильтр по объёму SSD, введите - 4\n" +
                            "Фильтр по семейству процессоров, введите - 5\n" +
                            "Фильтр по диагонали экрана, введите - 6\n" +
                            "Если Вы хотите посмотреть все модели, введите - 7\n" +
                            "Для выхода из меню введите - 0");

            String operation = scanner.nextLine();
            switch (operation) {
                case "1":
                    filterBrand(laptops, scanner);
                    break;
                case "2":
                    filterColour(laptops, scanner);
                    break;
                case "3":
                    filterRAM(laptops, scanner);
                    break;
                case "4":
                    filterSSDCapacity(laptops, scanner);
                    break;
                case "5":
                    filterProcessorFamily(laptops, scanner);
                    break;
                case "6":
                    filterScreenDiagonal(laptops, scanner);
                    break;
                case "7":
                    showModels(laptops);
                    break;
                case "0":
                    System.out.println("Добро пожаловать в сеть магазинов цифровой и бытовой техники");
                    filter = false;
                    break;
                default:
                    System.out.println("Такой страницы не существует");
                    System.out.println();
                    break;
            }
        }
    }

    public static void filterBrand(HashSet<laptop> laptops, Scanner scanner) {
        TreeSet<String> brand = new TreeSet<>();
        for (laptop checkmark: laptops) {
            brand.add(checkmark.getBrand());
        }
        System.out.println();
        System.out.println("У нас есть ноутбуки следующих производителей: "
                + brand.toString().replaceAll("^\\[|\\]$", "") + "\n" +
                "Введите интересующего Вас производителя: ");

        String operator = scanner.nextLine().toUpperCase();
        if (brand.contains(operator)) {
            System.out.println();
            System.out.println("Показать подходящие модели: ");
            System.out.println();
            for (laptop checkmark: laptops) {
                if (checkmark.getBrand().equals(operator)) {
                    checkmark.Info();
                }
            }
        } else {
            System.out.println("Такого производителя нет, попробуйте выбрать заново.");
            filterBrand(laptops, scanner);
        }
    }

    public static void filterColour(HashSet<laptop> laptops, Scanner scanner) {
        TreeSet<String> colour = new TreeSet<>();
        for (laptop checkmark: laptops) {
            colour.add(checkmark.getColour());
        }
        System.out.println();
        System.out.println("У нас есть ноутбуки следующих цветов: "
                + colour.toString().replaceAll("^\\[|\\]$", "") + "\n" +
                "Введите интересующий Вас цвет: ");

        String operator = scanner.nextLine().toLowerCase();
        if (colour.contains(operator)) {
            System.out.println();
            System.out.println("Показать подходящие модели: ");
            System.out.println();
            for (laptop checkmark: laptops) {
                if (checkmark.getColour().equals(operator)) {
                    checkmark.Info();
                }
            }
        } else {
            System.out.println("Такого цвета нет, попробуйте выбрать заново.");
            filterColour(laptops, scanner);
        }
    }

    public static void filterRAM(HashSet<laptop> laptops, Scanner scanner) {
        TreeSet<String> RAM = new TreeSet<>();
        for (laptop checkmark: laptops) {
            RAM.add(checkmark.getRAM());
        }
        System.out.println();
        System.out.println("У нас есть ноутбуки со следующим объёмом оперативной памяти: "
                + RAM.toString().replaceAll("^\\[|\\]$", "") + "\n" +
                "Введите интересующий Вас объём оперативной памяти: ");

        String operator = scanner.nextLine().toLowerCase();
        if (RAM.contains(operator)) {
            System.out.println();
            System.out.println("Показать подходящие модели: ");
            System.out.println();
            for (laptop checkmark: laptops) {
                if (checkmark.getRAM().equals(operator)) {
                    checkmark.Info();
                }
            }
        } else {
            System.out.println("Такого объёма оперативной памяти нет, попробуйте выбрать заново.");
            filterRAM(laptops, scanner);
        }
    }

    public static void filterSSDCapacity(HashSet<laptop> laptops, Scanner scanner) {
        TreeSet<String> SSDCapacity = new TreeSet<>();
        for (laptop checkmark: laptops) {
            SSDCapacity.add(checkmark.getSSDCapacity());
        }
        System.out.println();
        System.out.println("У нас есть ноутбуки со следующим объёмом SSD: "
                + SSDCapacity.toString().replaceAll("^\\[|\\]$", "") + "\n" +
                "Введите интересующий Вас объём SSD: ");

        String operator = scanner.nextLine().toLowerCase();
        if (SSDCapacity.contains(operator)) {
            System.out.println();
            System.out.println("Показать подходящие модели: ");
            System.out.println();
            for (laptop checkmark: laptops) {
                if (checkmark.getSSDCapacity().equals(operator)) {
                    checkmark.Info();
                }
            }
        } else {
            System.out.println("Такого объёма SSD нет, попробуйте выбрать заново.");
            filterSSDCapacity(laptops, scanner);
        }
    }

    public static void filterProcessorFamily(HashSet<laptop> laptops, Scanner scanner) {
        TreeSet<String> processorFamily = new TreeSet<>();
        for (laptop checkmark: laptops) {
            processorFamily.add(checkmark.getProcessorFamily());
        }
        System.out.println();
        System.out.println("У нас есть ноутбуки со следующим семейством процессоров: "
                + processorFamily.toString().replaceAll("^\\[|\\]$", "") + "\n" +
                "Введите интересующее Вас семейство процессоров: ");

        String operator = scanner.nextLine().toLowerCase();
        if (processorFamily.contains(operator)) {
            System.out.println();
            System.out.println("Показать подходящие модели: ");
            System.out.println();
            for (laptop checkmark: laptops) {
                if (checkmark.getProcessorFamily().equals(operator)) {
                    checkmark.Info();
                }
            }
        } else {
            System.out.println("Такого семейства процессоров нет, попробуйте выбрать заново.");
            filterProcessorFamily(laptops, scanner);
        }
    }

    public static void filterScreenDiagonal(HashSet<laptop> laptops, Scanner scanner) {
        TreeSet<String> screenDiagonal = new TreeSet<>();
        for (laptop checkmark: laptops) {
            screenDiagonal.add(checkmark.getScreenDiagonal());
        }
        System.out.println();
        System.out.println("У нас есть ноутбуки со следующими диагоналями экрана: "
                + screenDiagonal.toString().replaceAll("^\\[|\\]$", "") + "\n" +
                "Введите интересующую Вас диагональ экрана: ");

        String operator = scanner.nextLine().toLowerCase();
        if (screenDiagonal.contains(operator)) {
            System.out.println();
            System.out.println("Показать подходящие модели: ");
            System.out.println();
            for (laptop checkmark: laptops) {
                if (checkmark.getScreenDiagonal().equals(operator)) {
                    checkmark.Info();
                }
            }
        } else {
            System.out.println("Такой диагонали экрана нет, попробуйте выбрать заново.");
            filterScreenDiagonal(laptops, scanner);
        }
    }

    public static void showModels(HashSet<laptop> laptops) {
        System.out.println();
        System.out.println("Здесь Вы можете ознакомиться со всеми моделями: ");
        System.out.println();
        for (laptop checkmark: laptops) {
            checkmark.Info();
        }
    }
}