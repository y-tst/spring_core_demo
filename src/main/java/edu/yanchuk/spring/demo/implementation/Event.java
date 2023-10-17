package edu.yanchuk.spring.demo.implementation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Event {

    private long id;
    private String name;

    public Event(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
