package com.cafe.order.domain.favorite.ctrl;

import com.cafe.order.domain.favorite.dto.FavoriteMenuResponse;
import com.cafe.order.domain.favorite.entity.FavoriteMenu;
import com.cafe.order.domain.favorite.service.FavoriteMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        String customerId = "1";

        List<FavoriteMenuResponse> favorites = favoriteMenuService.favoriteMenuList(customerId);

        model.addAttribute("favorites", favorites);

        return "customer/favorites/list";
    }

    /**
     * POST : 찜 상태 변경
     */
    @PostMapping("/{menuId}/toggle")
    public String toggleFavorite(@PathVariable UUID menuId) {
        // todo : 로그인 이후 수정
        String customerId = "1";

        favoriteMenuService.toggleFavorite(customerId, menuId);

        return "redirect:/customer/menus/" + menuId;
    }
}
