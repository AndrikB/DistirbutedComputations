package com.univ.labs;
/*
Клеточный автомат: игра "Жизнь"
Основная идея — разделить пространство физической или биологической задачи на отдельные клетки. Каждая клетка — это конечный автомат. После инициализации все клетки сначала совершают один переход в новое состояние, затем второй переход и т.д. Результат каждого перехода зависит от текущего состояния клетки и ее соседей.
Дано двухмерное поле клеток. Каждая клетка либо содержит организм (жива), либо пуста (мертва). В этой задаче каждая клетка имеет восемь соседей, которые расположены сверху, снизу, слева, справа и по четырем диагоналям от нее. У клеток в углах по три соседа, а на границах — по пять.
Игра "Жизнь" происходит следующим образом. Сначала поле инициализируется. Затем каждая клетка проверяет состояние свое и своих соседей и изменяет свое состояние в соответствии со следующими правилами.
•    Живая клетка, возле которой меньше двух живых клеток, умирает от одиночества.
•    Живая клетка, возле которой есть две или три живые клетки, выживает еще на одно поколение.
•    Живая клетка, возле которой находится больше трех живых клеток, умирает от перенаселения.
•    Мертвая клетка, рядом с которой есть ровно три живых соседа, оживает.
Этот процесс повторяется некоторое число шагов (поколений).
См. также http://life.written.ru/game_of_life_review_by_gardner

а) Предусмотреть развитие цивилизации (живые клетки) в нескольких потоках, объяснить выбранный вариант эфективного распределения клеток по потокам

б) Одновременно стартовать несколько цивилизаций разными цветами при конкуренции за ресурсы (клетки) использовать атомарные операции, семафоры или мониторы, при изменении состояния клетки.
 */
public class Main {

    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
    }
}
