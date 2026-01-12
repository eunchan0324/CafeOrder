package com.cafe.order.domain.favorite.ctrl;

import com.cafe.order.domain.favorite.dto.FavoriteMenuResponse;
import com.cafe.order.domain.favorite.entity.FavoriteMenu;
import com.cafe.order.domain.favorite.service.FavoriteMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/customer/favorites")
@RequiredArgsConstructor
@Controller
public class FavoriteMenuController {

    private final FavoriteMenuService favoriteMenuService;

    /**
     * READ : 구매자 찜 목록 조회
     */
    @GetMapping
    public String favoriteMenuList(Model model) {
        // todo : 로그인 후 수정
        Integer userId = 1;

        List<FavoriteMenuResponse> favorites = favoriteMenuService.favoriteMenuList(userId);

        model.addAttribute("favorites", favorites);

        return "customer/favorites/list";
    }

    /**
     * POST : 찜 상태 변경
     */
    @PostMapping("/{menuId}/toggle")
    public String toggleFavorite(@PathVariable UUID menuId,
                                 @RequestParam(defaultValue = "") String redirect) {
        // todo : 로그인 이후 수정
        Integer userId = 1;

        favoriteMenuService.toggleFavorite(userId, menuId);

        // 리다이렉트 분기 처리
        // 만약 리스트 페이지에서 요청했다면(redirect="list') 다시 찜 목록으로 돌아감
        if ("list".equals(redirect)) {
            return "redirect:/customer/favorites";
        }

        // 그 외 (상세 페이지 등)에서는 해당 메뉴 상세 페이지로 돌아감
        return "redirect:/customer/menus/" + menuId;
    }
}
