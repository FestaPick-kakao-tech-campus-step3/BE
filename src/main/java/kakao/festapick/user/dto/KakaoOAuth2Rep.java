package kakao.festapick.user.dto;

import kakao.festapick.user.domain.SocialType;

import java.util.Map;

public class KakaoOAuth2Rep implements OAuth2Response {

    private final Map<String, Object> attributes;
    private final Map<String, Object> profile;
    private final Map<String, Object> kakaoAccount;

    public KakaoOAuth2Rep(Map<String, Object> attributes) {
        this.attributes = attributes;
        this.kakaoAccount = (Map<String,Object>) attributes.get("kakao_account");
        this.profile = (Map<String,Object>) kakaoAccount.get("profile");
    }


    @Override
    public SocialType getProvider() {
        return SocialType.KAKAO;
    }

    @Override
    public String getProviderId() {
        return attributes.get("id").toString();
    }

    @Override
    public String getUsername() {
        return profile.get("nickname").toString();
    }

    @Override
    public String getEmail() {
        return kakaoAccount.get("email").toString();
    }
}
