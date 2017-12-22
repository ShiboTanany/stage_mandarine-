package com.ntgclarity.mandarine.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ntgclarity.mandarine.dto.Order.AddOrderDto;
import com.ntgclarity.mandarine.dto.Order.AttributeDto;
import com.ntgclarity.mandarine.entity.Attribute;
import com.ntgclarity.mandarine.entity.AttributeValue;
import com.ntgclarity.mandarine.entity.Orders;
import com.ntgclarity.mandarine.entity.Service;
import com.ntgclarity.mandarine.exception.ApplicationException;
import com.ntgclarity.mandarine.service.AttributeService;
import com.ntgclarity.mandarine.service.AttributeValueService;
import com.ntgclarity.mandarine.service.OrderService;
import com.ntgclarity.mandarine.service.ServiceService;

@org.springframework.stereotype.Service
public class OrderMapper {
	@Autowired
	ServiceService serviceService;

	@Autowired
	OrderService orderService;
	@Autowired
	AttributeValueService attributeValueService;
	@Autowired
	AttributeService attributeService;

	public Orders toOrders(AddOrderDto orderDto) {
		Orders order = new Orders();
		Service service = serviceService.getServiceById(orderDto.getServiceDto().getId());
		if (service == null)
			throw new ApplicationException("400", "service not found");
		order.setServiceid(service);
		order.setAddress(orderDto.getAddress());
		order.setEmail(orderDto.getEmail());
		order.setPhone(orderDto.getPhone());
		order.setUserName(orderDto.getUserName());
		order.setQuantity(orderDto.getQuantity());
		orderService.save(order);
		// List<AttributeValue> attributeValues = new ArrayList<>();
		AttributeValue attributeValue;
		Attribute attribute;
		for (AttributeDto attributeDto : orderDto.getServiceDto().getAttributesValue()) {
			attributeValue = new AttributeValue();
			attribute = attributeService.getOneAttribute(attributeDto.getId());
			attributeValue.setAttributeId(attribute);
			attributeValue.setServiceId(service);
			attributeValue.setOrderId(order);
			attributeValue.setValue(attributeDto.getValue());
			attributeValueService.save(attributeValue);
		}
		// order.setAttributeValueCollection(attributeValueCollection);

		return order;
	}
}
