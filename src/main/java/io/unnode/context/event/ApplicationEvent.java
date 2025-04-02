package io.unnode.context.event;

import java.util.EventObject;

public abstract class ApplicationEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     * 后续所有事件的类都需要继承这个类
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }

}