package org.csu.mypetstore.controller;

import org.csu.mypetstore.Util.TranslateUtil;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/translationText")
@CrossOrigin
public class TranslationTextController {

    @GetMapping("/{text}")
    public String getTranslation(@PathVariable("text") String text) throws UnsupportedEncodingException {
        return TranslateUtil.translate(text);
    }
}
