package hw_0;

//Пользователю должно быть предложены выбрать доп.ингредиенты для бургера(стоимость бургера - 50)
//  с указанием цен!(Соус - 10, Сыр - 20, котлета - 30,).
// После того, как пользователь ввёл доп. ингредиенты в консоль(или название или номер),
// спросить хочет ли пользователь добавить 2-й ингредиент, если он вводит "нет",
// тогда вывести в консоль стоимость бургера с доп. ингредиентом(-ами)!
//P.S. Создать новый проект, залить Вашу программу на гит и в лмс скинуть ссылку!

import java.util.ArrayList;
import java.util.Scanner;

public class Burger {

    int burgerPrice = 50;
    ArrayList<Integer> burgerIngredients = new ArrayList<>();

    public void orderBurger() {
        System.out.println("Hello, you ordered burger! ");
        Scanner scanner = new Scanner(System.in);
        showIngredients();
        shouldAddIngredients(scanner);
    }

    private void shouldAddIngredients(Scanner scanner) {
        System.out.println("Do you want to add additions to your burger? (Answer yes or no)");
        String userInput = scanner.next();

        if (userInput.equals("yes")) {
            System.out.println("Please write what do you want to add from our list:");
            burgerIngredients.add(selectIngredients(scanner));
            shouldAddIngredients(scanner);
        } else {
            for (int ingredientPrice : burgerIngredients) {
                burgerPrice += ingredientPrice;
            }
            System.out.println("Your burger price is " + burgerPrice + " uah with all ingredients.");
        }
    }

    private int selectIngredients(Scanner scanner) {
        int ingredientPrice = 0;
        String ingredientFromUser = scanner.next();
        for (BurgerIngredients ingredient : BurgerIngredients.values()) {
            if (ingredientFromUser.matches(".*\\d.*") ?
                    Integer.parseInt(ingredientFromUser) == ingredient.getId() :
                    ingredientFromUser.equals(ingredient.getIngredient())) {
                ingredientPrice = getPriceForIngredient(ingredient);
                break;
            }
        }
        return ingredientPrice;
    }

    private int getPriceForIngredient(BurgerIngredients ingredient) {
        int priceForAddition = ingredient.getPrice();
        System.out.println(String.format("%s was added to your burger, burger price is %s uah", ingredient.getIngredient(), priceForAddition));
        return priceForAddition;
    }

    private void showIngredients() {
        System.out.println("Please check out our additions!");
        for (BurgerIngredients ingredient : BurgerIngredients.values()) {
            System.out.println(ingredient.getIngredient() + " " + ingredient.getPrice() + " " + "UAH");
        }
    }
}

