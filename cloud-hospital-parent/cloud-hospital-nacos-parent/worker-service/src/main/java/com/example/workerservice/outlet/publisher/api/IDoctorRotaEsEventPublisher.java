package com.example.workerservice.outlet.publisher.api;

import com.example.workerservice.service.command.doctorrota.add.AddDoctorRotaCommand;
import com.example.workerservice.service.command.doctorrota.update.UpdateDoctorRotaCommand;
import org.springframework.context.ApplicationEvent;

/**
 * Publisher - EsEvnet - DoctorRota
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/26
 */
public interface IDoctorRotaEsEventPublisher {

    void insert(AddDoctorRotaEsEvent event);

    void update(UpdateDoctorRotaEsEvent event);

    /**
     * 内部类 - EsEvent - AddDoctorRota
     */
    class AddDoctorRotaEsEvent extends ApplicationEvent {
        public AddDoctorRotaEsEvent(AddDoctorRotaCommand command) {
            super(command);
        }
    }

    /**
     * 内部类 - EsEvent - UpdateDoctorRota
     */
    class UpdateDoctorRotaEsEvent extends ApplicationEvent {
        public UpdateDoctorRotaEsEvent(UpdateDoctorRotaCommand command) {
            super(command);
        }
    }

}
