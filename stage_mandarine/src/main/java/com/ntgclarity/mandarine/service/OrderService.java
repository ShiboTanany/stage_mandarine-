
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntgclarity.mandarine.dto.OrderDto;
import com.ntgclarity.mandarine.dto.Order.AddOrderDto;
import com.ntgclarity.mandarine.entity.AttributeValue;
import com.ntgclarity.mandarine.entity.Orders;
import com.ntgclarity.mandarine.repository.OrderRepository;
import com.ntgclarity.mandarine.service.base.BaseRepository;
import com.ntgclarity.mandarine.service.base.BaseService;

/**
 *
 * @author Sheko
 */
@Service
public class OrderService extends BaseService<Orders> {

	@Autowired
	OrderRepository orderRepository;

	public List<Orders> getAllComponent() {
		List<Orders> components = new ArrayList<>();
		orderRepository.findAll().forEach((t) -> {
			components.add(t);
		});
		return components;
	}

	public void addComponent(Orders orders) {
		orderRepository.save(orders);
	}

	public void updateComponent(Orders orders) {
		orderRepository.save(orders);
	}

	public void deleteComponent(Orders orders) {
		orders.setDeleted(1);
		orderRepository.save(orders);
	}

	public Orders getOneComponent(Long Id) {
		return orderRepository.findOne(Id);
	}

	@Override
	public BaseRepository<Orders> getRepositoryInstance() {
		return orderRepository;
	}

	public boolean valid(AddOrderDto orders) {
		// TODO Auto-generated method stub
		if (orders.getAddress().trim().isEmpty())
			return false;
		if (orders.getEmail().trim().isEmpty())
			return false;
		if (orders.getPhone().trim().isEmpty())
			return false;
		if (orders.getUserName().trim().isEmpty())
			return false;
		if (orders.getQuantity() < 0)
			return false;
		return true;
	}

	public List<OrderDto> getAllOrders() {
		List<OrderDto> orderDtos = new ArrayList<>();
		List<Orders> orders = (List<Orders>) orderRepository.findAll();
		orders.forEach((order) -> {

			OrderDto orderDto = new OrderDto();
			orderDto.setAddress(order.getAddress());
			orderDto.setEmail(order.getEmail());
			orderDto.setPhone(order.getPhone());
			orderDto.setQuantity(order.getQuantity());
			orderDto.setUserName(order.getUserName());

			for (AttributeValue attributeValue : order.getAttributeValueCollection()) {
				System.out.println(attributeValue.getValue());
				orderDto.addAttribute(attributeValue.getAttributeId().getName(), attributeValue.getValue());
			}
			orderDtos.add(orderDto);
		});
		return orderDtos;
	}
	public int totalCount()
	{
		return (int) orderRepository.count();
	}
}
