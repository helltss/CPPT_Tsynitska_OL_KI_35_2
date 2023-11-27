import math
class ExpressionCalculator:
    @staticmethod
    def calculate_expression(x, pi_check_box):
        if pi_check_box and (abs(4 * x) == 0.5 or (4 * x - 0.5) % 1 == 0):
            result = 0
        else:
            result = 1 / math.cos(4 * x)

        if math.isinf(result) or math.isnan(result):
            ExpressionCalculator.write_result_to_file(fileName, x, result)
            raise ArithmeticError("Division by zero: cos(4x) equals zero.")

        return result

    @staticmethod
    def write_result_to_file(file_name, x, result):
        with open(file_name + ".txt", "w") as file:
            file.write(f"Введене значення X: {x}\n")
            file.write(f"Значення y при x = {x} дорівнює {result}\n")
