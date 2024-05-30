package br.com.tasklist.entity.dto;

import br.com.tasklist.entity.Task;
import br.com.tasklist.entity.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

    private Long idTask;
    private String descTask;
    private LocalDateTime dataInit;
    private LocalDateTime dataClose;
    private Status status;

}
