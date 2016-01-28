package com.blinch.server.service.appointment;

import com.blinch.server.domain.appointment.Appointment;
import com.blinch.server.domain.appointment.AppointmentDTO;
import com.blinch.server.domain.appointment.AppointmentRepository;
import com.blinch.server.domain.customer.Customer;
import com.blinch.server.domain.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * Created by markuskopf on 28/01/16.
 */

@Service
final public class MongoDBAppointmentService implements AppountmentService {

    final AppointmentRepository appointmentRepository;
    final CustomerRepository customerRepository;

    @Autowired
    public MongoDBAppointmentService(AppointmentRepository appointmentRepository, CustomerRepository customerRepository) {
        this.appointmentRepository = appointmentRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public AppointmentDTO create(AppointmentDTO appointment) {

        HashSet<Customer> lunchPartners = new HashSet<Customer>();

        for (Customer value : appointment.getCustomers()) {
            lunchPartners.add(this.customerRepository.findByLastName(value.getLastName()).get());
        }

        Appointment persisted = new Appointment(lunchPartners,
                appointment.getAppointmentDate(),
                appointment.getLocationName(),
                appointment.getLongitute(),
                appointment.getLatitude(),
                appointment.getCity());

        persisted = this.appointmentRepository.save(persisted);

        return convertToDTO(persisted);
    }

    @Override
    public AppointmentDTO delete(String id) {
        return null;
    }

    private AppointmentDTO convertToDTO(Appointment appointment) {
        AppointmentDTO dto = new AppointmentDTO(appointment.getId(),
                appointment.getCustomers(),
                appointment.getAppointmentDate(),
                appointment.getLocationName(),
                appointment.getLongitute(),
                appointment.getLatitude(),
                appointment.getCity());

        return dto;
    }

}