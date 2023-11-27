
class RowingBoat:
    def __init__(self, capacity, length):
        self.capacity = capacity
        self.length = length
        self.passengers = 0  # Початкова кількість пасажирів
        self.is_anchored = True  # Чи висажена якорем

    def row(self):
        if not self.is_anchored:
            print("Весла рухають шлюпку")
        else:
            print("Шлюпка висажена якорем і не може рухатися")

    def embark_passenger(self):
        if self.passengers < self.capacity:
            self.passengers += 1
            print("Пасажир сів в шлюпку")
        else:
            print("Шлюпка вже повна, не можна сісти")

    def anchor(self):
        self.is_anchored = True
        print("Шлюпка висажена якорем")

    def raise_anchor(self):
        self.is_anchored = False
        print("Підняти якір")

    def display_info(self):
        print(f"Шлюпка на веслах, вмістимість: {self.capacity}, довжина: {self.length} метрів")
        print(f"Пасажирів на борту: {self.passengers}")
        if self.is_anchored:
            print("Шлюпка висажена якорем")
        else:
            print("Шлюпка не висажена якорем")