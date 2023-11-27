from RowingBoat import RowingBoat
from MotorBoat import MotorBoat

if __name__ == "__main__":
    rowboat = RowingBoat(4, 3.5)
    motorboat = MotorBoat(6, 5.0, "Дизельний")

    # Використовуємо оновлені методи базового класу
    rowboat.embark_passenger()
    rowboat.embark_passenger()
    rowboat.raise_anchor()

    # Виклик методу row після підняття якоря
    rowboat.row()

    rowboat.display_info()

    motorboat.start_engine()
    motorboat.display_info()