package croc.education.ws2023spb.knightsmove;


/**
 * Класс, содержащий методы преобразования в объект расположения фигуры на шахматной доске из различных форматов.
 *
 * @author Dmitry Malenok
 * @see ChessPosition
 */
public final class ChessPositionParser {

    /**
     * Конструктор.
     */
    private ChessPositionParser() {
        // Конструктор задан только для того, чтобы экземпляр класса случайно не создали.
    }

    /**
     * Разбирает наименование клетки шахматной доски, на которой находится фигура, в
     * <a href="https://w.wiki/7pFN">шахматной нотации</a> и возвращает соответствующий ей объект расположения фигуры на
     * шахматной доске.
     *
     * @param position наименование клетки шахматной доски, на которой находится фигура
     * @return объект расположения фигуры на шахматной доске, соответствующий переданному наименованию клетки
     */
    public static ChessPosition parse(final String position) {
        if (position.length() != 2)
            throw new IllegalPositionException("position" + position + "is formatted wrongly. It must be in the form 1a-8h, not case sensitive");

        int HorizontalChar = position.toLowerCase().charAt(0);
        int VerticalChar = position.charAt(1);

        if (HorizontalChar < 'a' || 'h' < HorizontalChar || VerticalChar < '1' || VerticalChar > '8') {
            throw new IllegalPositionException("The position is out of bounds");
        }

        var x = HorizontalChar - 'a';
        var y = VerticalChar - '1';

        return new ChessPosition() {
            @Override
            public int x() {
                return x;
            }

            @Override
            public int y() {
                return y;
            }

            @Override
            public String toString() {
                return String.format("%s%s", (char) ('a' + x()), (y() + 1));
            }

        };
    }
}
