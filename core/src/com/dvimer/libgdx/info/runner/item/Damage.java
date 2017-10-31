//package com.dvimer.libgdx.info.runner.item;
//
//import com.badlogic.gdx.math.Vector2;
//import com.badlogic.gdx.utils.Pool;
//
///**
// * Created by dvime_000 on 31.10.2017.
// */
//public class Damage implements Pool.Poolable {
//    public Vector2 position;
//    public boolean alive;
//
//    /**
//     * Конструктор пули. Простая инициализация переменных.
//     */
//    public Damage() {
//        this.position = new Vector2();
//        this.alive = false;
//    }
//
//    /**
//     * Инициализация пули. Вызовите этот метод после получения пули из пула.
//     */
//    public void init(float posX, float posY) {
//        position.set(posX,  posY);
//        alive = true;
//    }
//
//    /**
//     * Метод обратного вызова, когда объект освобожден.
//     * Автоматически вызывается Pool.free() методом.
//     * Необходимо сбросить каждое смысловое поле данной пули
//     */
//    public void reset() {
//        position.set(0,0);
//        alive = false;
//    }
//
//    /**
//     * Метод вызывается при каждом кадре и обновляет пулю.
//     */
//    public void update (float delta) {
//
//        // обновление позиции пули
//        position.add(1*delta*60, 1*delta*60);
//
//        // если пуля вне экрана, установка состояние в "мертвая"
//        if (isOutOfScreen()) alive = false;
//    }
//}
//
