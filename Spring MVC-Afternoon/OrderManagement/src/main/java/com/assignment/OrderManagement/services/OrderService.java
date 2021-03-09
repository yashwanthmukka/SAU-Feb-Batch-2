package com.assignment.OrderManagement.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assignment.OrderManagement.model.Order;
import com.assignment.OrderManagement.model.OrderItem;
import com.assignment.OrderManagement.model.OrdersManagement;

@Service
public class OrderService {

    private int lastOrderIdGiven, lastItemIdGiven;
    private OrdersManagement orders;

    public OrderService(){
        this.lastOrderIdGiven = 0;
        this.lastItemIdGiven = 0;
        orders = new OrdersManagement();
    }

    public Order createOrder(Order order){
        order.setId(++lastItemIdGiven);
       // orders.setOrdersList(order);
        return order;
    }

    public List<Order> getAllOrders(){
        return orders.getOrdersList();
    }

    public Order addItemToOrder(int orderId, OrderItem item){
        Order currentOrder = orders.getOrder(orderId);
        item.setId(++lastOrderIdGiven);
        if(currentOrder.addItem(item)) {
            return currentOrder;
        }
        return null;
    }

    public List<OrderItem> getOrderItems(int orderId){
        Order currentOrder = orders.getOrder(orderId);
        return currentOrder.getItemsList();
    }

    public boolean checkOrderItem(int orderId){
        Order currentOrder = orders.getOrder(orderId);
        if(currentOrder == null){
            return false;
        }
        return true;
    }

    public boolean removeItemFromOrder(int orderId, int itemId){
        Order currentOrder = orders.getOrder(orderId);
        return currentOrder.removeItem(itemId);
    }

    public OrderItem updateItem(int itemId, int orderId, OrderItem item){
        Order currentOrder = orders.getOrder(orderId);
        item.setId(++lastOrderIdGiven);
        return currentOrder.updateOrderItem(itemId, item);
    }

    public boolean removeOrder(int orderId){
        return orders.removeOrder(orderId);
    }
}