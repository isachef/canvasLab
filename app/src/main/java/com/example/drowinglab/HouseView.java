package com.example.drowinglab;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class HouseView extends View {

    private Paint paint;

    public HouseView(Context context) {
        super(context);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Устанавливаем цвет фона
        canvas.drawColor(Color.WHITE);

        // Рисуем солнце
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(100, 100, 50, paint);

        // Рисуем лучи солнца
        paint.setStrokeWidth(5);
        for (int i = 0; i < 360; i += 30) {
            float startX = (float) (100 + 50 * Math.cos(Math.toRadians(i)));
            float startY = (float) (100 + 50 * Math.sin(Math.toRadians(i)));
            float endX = (float) (100 + 80 * Math.cos(Math.toRadians(i)));
            float endY = (float) (100 + 80 * Math.sin(Math.toRadians(i)));
            canvas.drawLine(startX, startY, endX, endY, paint);
        }

        // Рисуем землю (траву)
        paint.setColor(Color.GREEN);
        canvas.drawRect(0, 600, getWidth(), getHeight(), paint);

        // Рисуем дом
        paint.setColor(Color.rgb(150, 75, 0));  // Коричневый цвет
        canvas.drawRect(400, 400, 700, 700, paint);

        // Рисуем крышу
        paint.setColor(Color.DKGRAY);
        float[] roofPoints = {400, 400, 700, 400, 550, 250};
        canvas.drawVertices(Canvas.VertexMode.TRIANGLES, 6, roofPoints, 0, null, 0, null, 0, null, 0, 0, paint);

        // Окно
        paint.setColor(Color.BLUE); // Синий цвет для окна
//        canvas.drawRect(350, 650, 450, 750, paint);

        canvas.drawRect(420, 500, 520, 600, paint);
        // Цикл для диагональных линий на окне
        paint.setColor(Color.BLACK);
        for (int i = 0; i < 100; i += 10) {
            canvas.drawLine(420 + i, 500, 420, 500 + i, paint); // Линии слева направо
            canvas.drawLine(520, 500 + i, 420 + i, 600, paint); // Линии справа налево
        }

        // Дверь
        paint.setColor(Color.rgb(160, 82, 45)); // Светло-коричневый для двери
//        canvas.drawRect(475, 750, 575, 900, paint);
        canvas.drawRect(555, 500, 655, 700, paint);

        // Цикл для диагональных линий на двери
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(2);

        for (int i = 0; i < 100; i += 10) {
            canvas.drawLine(555 , 500+i*2, 655, 500+i*2 , paint); // Линии слева направо
            canvas.drawLine(555+i, 500 , 555 + i, 700, paint); // Линии справа налево
        }
        // Рисуем дерево
        paint.setColor(Color.rgb(34, 139, 34));  // Зеленый цвет
        canvas.drawOval(820, 400, 900, 600, paint);  // Крона дерева
        paint.setColor(Color.rgb(139, 69, 19));  // Ствол
        canvas.drawRect(850, 600, 870, 700, paint);

        // Рисуем скамейку
        paint.setColor(Color.GRAY);
        canvas.drawRect(900, 650, 1000, 670, paint);  // Сиденье
        canvas.drawRect(910, 670, 930, 700, paint);  // Ножки
        canvas.drawRect(970, 670, 990, 700, paint);
    }
}
