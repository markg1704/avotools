package com.markg1704.avotools.controllers;

import com.markg1704.avotools.datamodel.dto.LayerDTO;
import com.markg1704.avotools.services.LayerService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LayerControllerTest {
    
    LayerController sut;
    private LayerService layerService;

    private LayerDTO dummy_A;
    private LayerDTO dummy_B;
    
    @BeforeAll
    public void setup() {
        layerService = mock(LayerService.class);
        sut = new LayerController(layerService);
        
        Long id_A = 1L;
        String well_A = "Well-1";
        String name_A = "Dummy A";
        Long projectID_A = 123L;
        String fluidType_A = "Oil";
        String rockType_A = "Sand";
        double vP_A = 3.456d;
        double vS_A = 2.123d;
        double den_A = 2.25d;
        dummy_A = new LayerDTO(id_A, well_A, name_A, projectID_A, fluidType_A, rockType_A, vP_A, vS_A, den_A);

        Long id_B = 1L;
        String well_B = "Well-2";
        String name_B = "Dummy B";
        Long projectID_B = 189L;
        String fluidType_B = "Water";
        String rockType_B = "Shale";
        double vP_B = 2.456d;
        double vS_B = 1.123d;
        double den_B = 2.45d;
        dummy_B = new LayerDTO(id_B, well_B, name_B, projectID_B, fluidType_B, rockType_B, vP_B, vS_B, den_B);

    }
    
    @Test
    public void shouldReturnListWhenGetLayersCalled() {
        Iterable<LayerDTO> list = Arrays.asList(dummy_A, dummy_B);
        when(layerService.getLayers()).thenReturn(Optional.of(list));

        ResponseEntity<Iterable<LayerDTO>> response = sut.getLayers();

        List<LayerDTO> body = (List<LayerDTO>) response.getBody();

        assertEquals(2, body.size());
        assertTrue(body.contains(dummy_A));
        assertTrue(body.contains(dummy_B));
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void shouldReturnEmptyWhenNoLayersToReturn() {
        when(layerService.getLayers()).thenReturn(Optional.of(new ArrayList<>()));

        ResponseEntity<Iterable<LayerDTO>> response = sut.getLayers();

        List<LayerDTO> body = (List<LayerDTO>) response.getBody();

        assertTrue(body.isEmpty());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void shouldReturnOKWhenLayerIdRequest() {
        Long searchId = 1L;
        when(layerService.getLayerById(searchId)).thenReturn(Optional.of(dummy_A));

        ResponseEntity<LayerDTO> response = sut.getLayerById(searchId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(dummy_A.equals(response.getBody()));
    }

    @Test
    public void shouldReturnOKWhenDeleteLayer() {
        Long deleteId = 1L;
        when(layerService.deleteLayer(deleteId)).thenReturn(Optional.of(Boolean.TRUE));

        ResponseEntity response = sut.deleteLayer(deleteId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void shouldReturnNotFoundWhenCannotDeleteLayer() {
        Long deleteId = 1L;
        when(layerService.deleteLayer(deleteId)).thenReturn(Optional.of(Boolean.FALSE));

        ResponseEntity response = sut.deleteLayer(deleteId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }


}
