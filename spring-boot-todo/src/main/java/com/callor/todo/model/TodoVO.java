package com.callor.todo.model;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name="tbl_todo")
public class TodoVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seq;

    private String todo;

    private String s_date;
    private String s_time;

    private String e_date;
    private String e_time;

    private boolean finish;
}
