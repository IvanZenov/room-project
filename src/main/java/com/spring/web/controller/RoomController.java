package com.spring.web.controller;

import com.spring.database.domain.Address;
import com.spring.database.domain.Room;
import com.spring.database.exception.RoomNotFoundException;
import com.spring.service.interfaces.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    //User actions
    @GetMapping(path = "/rooms")
    public String showAllRoomPage(Model model, @RequestParam(value = "query", required = false) String query) {
        List<Room> all = roomService.findWithParameter(query);
        model.addAttribute("rooms", all);
        return "rooms";
    }

    @GetMapping(path = "/rooms/{id}")
    public String showRoomWithId(@PathVariable("id") Long id, Model model) {
        Room room = roomService.findById(id);
        if (room==null) throw new RoomNotFoundException("Room with id " + id +  "not found");
        model.addAttribute("room", room);
        return "room-page";
    }

    //Admin actions
    @GetMapping(path = "/admin/rooms")
    public String showAddRoomPage(Model model) {
        List<Room> all = roomService.findAll();
        model.addAttribute("rooms", all);
        return "admin-room";
    }

    @GetMapping(value = "/admin/rooms/addNewRoom")
    public String showAddRoomPage() {
        return "admin-addNewRoom";
    }

    @PostMapping(value = "/admin/rooms/addNewRoom")
    public String addNewRoom(Model model, Room room, @RequestParam("city") String city
            , @RequestParam("streetNumber") String streetNumber, @RequestParam("street") String street) {

        model.addAttribute("room", room);
        room.setAddress(new Address(city, street, streetNumber));
        roomService.save(room);
        return "redirect:/admin/rooms";
    }

    @GetMapping(value = "/rooms/delete")
    public String deleteRoom(@RequestParam("id") String id) {
        roomService.delete(id);
        return "redirect:/rooms/manage";
    }

    @GetMapping(value = "/rooms/edit")
    public String editRoomPage(Model model, @RequestParam("id") String id) {
        Long roomId = Long.valueOf(id);
        Room found = roomService.findById(roomId);
        model.addAttribute("room", found);
        return "edit-room";
    }

    @PostMapping(value = "/rooms/edit")
    public String editRoom(Model model, Room room, @RequestParam("city") String city
            , @RequestParam("streetNumber") String streetNumber, @RequestParam("street") String street) {
        model.addAttribute("room", room);
        room.setAddress(new Address(city, street, streetNumber));
        roomService.update(room);
        return "redirect:/admin/rooms";
    }

}
