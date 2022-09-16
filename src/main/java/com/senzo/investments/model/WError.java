package com.senzo.investments.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
@ApiModel(value = "Error")
public class WError {
    @Value("${error.withdrawal.WE_1401}")
    public static String WE_1401;
    @Value("${error.withdrawal.WE_1401}")
    public static String WE_1402;
    @Value("${error.withdrawal.WE_1401}")
    public static String WE_1403;
    @Value("${error.withdrawal.WE_1401}")
    public static String WE_1404;

}
