package com.zmj.user.designPattern.buildPattern;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.buildPattern
 * @date 2023/10/18 15:54
 */
public class SkuBuilder<T extends SkuVo> {

    private SkuDo skuDo;

    private Boolean needCoupon;

    private SkuVoFunction<T> skuVoFunction;

    private SkuVoExtFunction<T> skuVoExtFunction;

    public static <T extends SkuVo> SkuBuilder<T> create() {
        return new SkuBuilder<T>();
    }

    public SkuBuilder<T> skuDo(SkuDo skuDo) {
        this.skuDo = skuDo;
        return this;
    }

    public SkuBuilder<T> skuDo(Boolean needCoupon) {
        this.needCoupon = needCoupon;
        return this;
    }

    public SkuBuilder<T> skuDo(SkuVoFunction<T> skuVoFunction) {
        this.skuVoFunction = skuVoFunction;
        return this;
    }

    public SkuBuilder<T> skuDo(SkuVoExtFunction<T> skuVoExtFunction) {
        this.skuVoExtFunction = skuVoExtFunction;
        return this;
    }


    public T build() {
        T skuVo = this.skuVoFunction.newInstance();
        skuVo.setSkuId(skuDo.getSkuId());
        skuVo.setName(skuDo.getSkuName());
        if (needCoupon) {
            //转换一些逻辑
            skuVo.setCouponText("");
        }

        if (this.skuVoExtFunction != null) {
            this.skuVoExtFunction.buildExtInfo(skuVo, skuDo);
        }

        return skuVo;
    }

}
