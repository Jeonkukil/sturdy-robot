package shop.mtcoding.momo.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import shop.mtcoding.momo.dto.board.BoardReq.BoardSaveReqDto;

public class HtmlParser {
    private void extracted(BoardSaveReqDto boardSaveReqDto) {
        // 1. content 내용을 Document로 받고 , img 찾아내서(0,1,2) src를찾아서 thumbnail에 추가
        String thumbnail = "";
        String a = boardSaveReqDto.getContent();
        Document doc = Jsoup.parse(a);
        Elements els = doc.select("img");
        if (els.size() == 0) {
            thumbnail = "/images/cat.jpg";
            boardSaveReqDto.setThumbnail(thumbnail);
        } else {
            Element el = els.get(0);
            thumbnail = el.attr("src");
            boardSaveReqDto.setThumbnail(thumbnail);
        }
    }

}
