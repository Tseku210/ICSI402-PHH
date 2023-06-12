package com.example.uliral;

import com.example.uliral.controller.DiplomController;
import com.example.uliral.model.DTO.DiplomDto;
import com.example.uliral.model.entities.Diplom;
import com.example.uliral.services.DiplomService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DiplomControllerTest {

    @Mock
    DiplomService diplomService;

    @Mock
    Model model;

    @InjectMocks
    DiplomController diplomController;

    @Test
    public void testGetAllDiploms() {
        Diplom diplom = new Diplom();
        List<Diplom> expectedDiploms = Collections.singletonList(diplom);
        when(diplomService.findAll("")).thenReturn(expectedDiploms);

        String result = diplomController.getAllDiploms(model, "");

        assertEquals("diplom", result);
    }

    @Test
    public void testAddDiplom() {
        DiplomDto diplomDto = new DiplomDto();

        String result = diplomController.addDiplom(diplomDto);

        assertEquals("redirect:/diplom", result);
    }
}
