package com.plus_api.central_plus.Service;

import com.plus_api.central_plus.Model.CommandModel;
import com.plus_api.central_plus.Repository.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandService {

    @Autowired
    private CommandRepository commandRepository;

    // Get all commands
    public List<CommandModel> getAllCommands() {
        return commandRepository.findAll();
    }

    // Get command by ID
    public CommandModel getCommandById(Long id) {
        return commandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Command not found"));
    }

    // Create a new command
    public CommandModel createCommand(CommandModel commandModel) {
        return commandRepository.save(commandModel);
    }

    // Update a command
    public CommandModel updateCommand(Long id, CommandModel commandDetails) {
        CommandModel commandModel = commandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Command not found"));

        commandModel.setStatus(commandDetails.getStatus());
        commandModel.setTotal(commandDetails.getTotal());
        commandModel.setCreationDate(commandDetails.getCreationDate());
        commandModel.setUpdateDate(commandDetails.getUpdateDate());
        commandModel.setDeliveryDate(commandDetails.getDeliveryDate());

        return commandRepository.save(commandModel);
    }

    // Delete a command
    public void deleteCommand(Long id) {
        if (!commandRepository.existsById(id)) {
            throw new RuntimeException("Command not found");
        }
        commandRepository.deleteById(id);
    }
}
