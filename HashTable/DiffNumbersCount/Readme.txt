Дан список чисел, который может содержать до 100000 чисел. Определите, сколько в нем встречается различных чисел.

Формат ввода
Вводится список целых чисел. Все числа списка находятся на одной строке.

Чисел очень много, просто 
        list = input();
        for (Integer n : list) {
            if (!res.contains(n)) res.add(n);
        }
не проходит по времени.
Поэтому здесь хеш-таблица, написанная руками ради тренировки материала из лекции. 
Работает за О(1), кроме случаев, когда колонка становится слишком длинной из-за коллизий. 
В таком случае таблица расширяется и пересчитывается за О(N).