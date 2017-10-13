package com.dvimer.libgdx.info.runner.publisher;

/**
 * Created by dvime_000 on 12.10.2017.
 */

public interface EventListener {
    void update(String type, String text);

    void update(String type, int value);

}
