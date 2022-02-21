package com.server.serverAPI.Infraestructura.Persistencia.DAO.InterfaceProjection;

import java.math.BigInteger;

public interface PurchaseListDTO {
    String getHeroName();
    BigInteger getPurchaseId();
    int getQuantity();
    String getProductName();
}
