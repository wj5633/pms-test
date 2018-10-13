package com.wj5633.pms.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author wj
 * @create 2018-09-14 1:40
 **/

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyException extends RuntimeException {
    private static final long serialVersionUID = -8353933508158842269L;
    private int code;
    private String msg;

}
