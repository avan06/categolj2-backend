package am.ik.categolj2.api.entry;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import am.ik.categolj2.domain.model.Entry;
import am.ik.categolj2.domain.service.entry.EntryService;

@Controller
@RequestMapping("entries")
public class EntryRestController {
    @Inject
    EntryService entryService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Page<Entry> getEntry(@PageableDefault Pageable pageable) {
        Page<Entry> page = entryService.findPage(pageable);
        return page;
    }

    @RequestMapping(value = "{entryId}", method = RequestMethod.GET)
    @ResponseBody
    public Entry getEntry(@PathVariable("entryId") Integer entryId) {
        Entry entry = entryService.findOnePublished(entryId);
        return entry;
    }
}
