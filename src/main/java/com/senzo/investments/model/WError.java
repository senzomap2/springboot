package com.senzo.investments.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
@ApiModel(value = "Error")
public class WError {

    public final static String WE_1401="You must be at least 65 years to withdraw a retirement product";
    public final static String WE_1402="You cannot withdraw more than your current balance";
    public final static String WE_1403="You cannot withdraw an AMOUNT more than 90% of the current BALANCE";
    public final static String WE_1404="We could not find your account with us, please try again";

}
