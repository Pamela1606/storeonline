package com.online.store.controller;

import com.online.store.models.Item;
import com.online.store.models.ItemImage;
import com.online.store.reporsitory.ItemImageRepository;
import com.online.store.service.StorageService;
import com.online.store.service.item.ItemDto;
import com.online.store.service.item.ItemService;
import com.online.store.service.itemImage.ItemImageDto;
import com.online.store.service.itemImage.ItemImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.File;
import java.time.LocalTime;
import java.util.Date;

@RestController
@RequestMapping(path = "v1/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    StorageService storageService;

    @Autowired
    StorageService ItemImaService;

    @Autowired
    ItemImageService itemImageService;

    @GetMapping
    public ResponseEntity<Object> getItems(Pageable pageable) {
        /**
         *
         * AQUI seteo las url
         */
        Page<ItemDto> itemDtos = itemService.findAll(pageable);
        for (ItemDto itemDto: itemDtos) {
            for ( ItemImage itemImage: itemDto.getItemImages()) {
                itemImage.setUrl(MvcUriComponentsBuilder.fromMethodName(ItemController.class, "getFile", itemImage.getUrl()).build().toString());
            }
        }
        return new ResponseEntity<>(itemDtos.getContent(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createItem(@RequestBody ItemDto itemDto) {
        return ResponseEntity.ok(itemService.createEntity(itemDto));
    }

    @PostMapping("/uploads")
    public ResponseEntity<String> uploadFiles(@RequestParam("file") MultipartFile file, @RequestParam("id") Long id) {
        String message = "";
        Date d = new Date( );
        long timestamp = d.getTime();
        try {

            storageService.store(file, timestamp + "");
           // ItemDto itemImage = this.itemService.getEntity(id);

            String fileName =timestamp + file.getOriginalFilename();

            ItemImageDto itemImageDto = new ItemImageDto();
            itemImageDto.setItemId(id);
            itemImageDto.setUrl(fileName );
            itemImageService.createEntity(itemImageDto);


            message = "You successfully uploaded " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }

    /**
     *
     * ME HE GUIADO EN ESTE LINK
     * https://grokonez.com/frontend/angular/angular-4-uploadget-images-tofrom-spring-boot-server
     * @param filename
     * @return
     */
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    private boolean  uploadFile(MultipartFile file) {
        try {
          //  storageService.store(file);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateItem(@PathVariable(value = "id") Long id, @RequestBody ItemDto itemDto) {
        return ResponseEntity.ok(itemService.updateEntity(itemDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteItem(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(itemService.deleteEntity(id));
    }
}
