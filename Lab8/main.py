import math
from ExpressionCalculator import ExpressionCalculator

def main():
    file_name = input("Введіть ім'я файлу: ")
    x = float(input("Введіть X: "))

    # Get input for pi_check_box
    pi_check_box_input = input("Is π checkbox selected? (true/false): ")
    pi_check_box = pi_check_box_input.lower() == "true"

    fileName = file_name  # Set fileName to file_name here

    try:
        with open(file_name + ".txt", "w", encoding="utf-8") as file_out:
            file_out.write(f"Введене значення X: {x}\n")
            file_out.write(f"Is pi checkbox selected? {pi_check_box}\n")  # Changed "π" to "pi"

            result = ExpressionCalculator.calculate_expression(x, pi_check_box)
            file_out.write(f"Результат: {result}\n")
            print(f"Результат: {result}")

    except FileNotFoundError as ex:
        print("Error writing to file:", ex)
    except ArithmeticError as ex:
        print("Division by zero: cos(4x) equals zero.")


if __name__ == "__main__":
    main()