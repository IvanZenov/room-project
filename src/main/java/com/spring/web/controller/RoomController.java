package com.spring.web.controller;

import com.spring.database.domain.Address;
import com.spring.database.domain.Room;
import com.spring.service.interfaces.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    //User actions

    @RequestMapping(path = "/rooms", method = RequestMethod.GET)
    public String showAllRoomPage (Model model,@RequestParam(value = "query", required = false) String query) {
        List<Room> all = roomService.findWithParameter(query);
        model.addAttribute("rooms", all);
        return "rooms";
    }

    @RequestMapping(path = "/rooms/{id}", method = RequestMethod.GET)
    public String showRoomWithId (@PathVariable("id") Long id, Model model) {
        Room room = roomService.findById(id);
        model.addAttribute("room", room);
        return "room-page";
    }


    //Admin actions
    @RequestMapping (path = "/rooms/manage", method = RequestMethod.GET)
    public String showAddRoomPage(Model model){
        List<Room> all = roomService.findAll();
        model.addAttribute("rooms", all);
        return "admin-room";
    }

    @GetMapping (value = "/rooms/newRoom")
    public String showAddRoomPage(){
        return "admin-addNewRoom";
    }

    @PostMapping (value = "/rooms/newRoom")
    public String addNewRoom(Model model, Room room, @RequestParam("city") String city
            , @RequestParam("streetNumber") String streetNumber,@RequestParam("street") String street ){

        model.addAttribute("room", room);
        room.setAddress(new Address(city,street,streetNumber));
        roomService.save(room);
        return "redirect:/rooms/manage";
    }

    @GetMapping (path = "/rooms/delete")
    public String deleteRoom(@RequestParam("id") String id){
        roomService.delete(id);
        return "redirect:/rooms/manage";
    }

}
