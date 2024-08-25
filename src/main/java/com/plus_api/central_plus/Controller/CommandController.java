package com.plus_api.central_plus.Controller;

import com.plus_api.central_plus.Model.CommandModel;
import com.plus_api.central_plus.Service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commands")
public class CommandController {

    @Autowired
    private CommandService commandService;

    @GetMapping
    public List<CommandModel> getAllCommands() {
        return commandService.getAllCommands();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommandModel> getCommandById(@PathVariable Long id) {
        CommandModel commandModel = commandService.getCommandById(id);
        return ResponseEntity.ok(commandModel);
    }

    @PostMapping
    public CommandModel createCommand(@RequestBody CommandModel commandModel) {
        return commandService.createCommand(commandModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommandModel> updateCommand(@PathVariable Long id, @RequestBody CommandModel commandDetails) {
        CommandModel updatedCommand = commandService.updateCommand(id, commandDetails);
        return ResponseEntity.ok(updatedCommand);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommand(@PathVariable Long id) {
        commandService.deleteCommand(id);
        return ResponseEntity.noContent().build();
    }
}
