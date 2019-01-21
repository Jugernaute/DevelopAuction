package ua.com.method.filter;

import ua.com.entity.*;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated( value  =  " org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor " )
@StaticMetamodel( Product.class)
public class Product_ {

    public  static  volatile  SingularAttribute < Product , Integer > id_Product;
    public  static  volatile  SingularAttribute < Product , String > modelProduct;
    public  static  volatile  SetAttribute < Product , StateProduct> stateProduct;
    public  static  volatile  SetAttribute < Product , TypeSell> typeSell;
    public  static  volatile  SetAttribute < Product , Comparison > comparison;
    public  static  volatile  SingularAttribute < Product , String > field;
    public  static  volatile  SetAttribute < Product , LocationLot > locationLots;
    public  static  volatile  SetAttribute < Product , SubCategory> subCategory;


}
