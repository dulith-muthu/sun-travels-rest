package it.suntravelrest.model.viewmodel;

import lombok.Data;

import java.util.Date;

@Data
public class ContractViewModel
{
    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private double markup;
    private String hotelId;
    private boolean isActive;
    private Date createdAt;
}
