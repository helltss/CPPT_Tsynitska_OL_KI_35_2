from RowingBoat import RowingBoat

class MotorBoat(RowingBoat):
    def __init__(self, capacity, length, engine_type):
        super().__init__(capacity, length)
        self.engine_type = engine_type
        self.fuel_level = 100  # Початковий рівень палива (припустимо, 100%)

    def start_engine(self):
        if self.fuel_level > 0:
            self.fuel_level -= 10  # Споживання палива при запуску двигуна
            print("Запуск двигуна човна")
        else:
            print("Немає палива. Двигун не може бути запущений.")

    def refuel(self, fuel_amount):
        if fuel_amount > 0:
            self.fuel_level += fuel_amount
            print(f"Додано {fuel_amount} одиниць палива")
        else:
            print("Неправильна кількість палива")

    def display_info(self):
        super().display_info()
        print(f"Моторний човен, тип двигуна: {self.engine_type}")
        print(f"Рівень палива: {self.fuel_level}%")