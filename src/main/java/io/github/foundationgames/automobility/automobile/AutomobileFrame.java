package io.github.foundationgames.automobility.automobile;

import io.github.foundationgames.automobility.Automobility;
import io.github.foundationgames.automobility.automobile.render.frame.*;
import io.github.foundationgames.automobility.util.SimpleMapContentRegistry;
import net.minecraft.client.model.Model;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public record AutomobileFrame(
        Identifier id,
        float weight,
        FrameModel model
) implements SimpleMapContentRegistry.Identifiable {

    public static final SimpleMapContentRegistry<AutomobileFrame> REGISTRY = new SimpleMapContentRegistry<>();

    public static final AutomobileFrame STANDARD_WHITE = REGISTRY.register(standard("white"));
    public static final AutomobileFrame STANDARD_ORANGE = REGISTRY.register(standard("orange"));
    public static final AutomobileFrame STANDARD_MAGENTA = REGISTRY.register(standard("magenta"));
    public static final AutomobileFrame STANDARD_LIGHT_BLUE = REGISTRY.register(standard("light_blue"));
    public static final AutomobileFrame STANDARD_YELLOW = REGISTRY.register(standard("yellow"));
    public static final AutomobileFrame STANDARD_LIME = REGISTRY.register(standard("lime"));
    public static final AutomobileFrame STANDARD_PINK = REGISTRY.register(standard("pink"));
    public static final AutomobileFrame STANDARD_GRAY = REGISTRY.register(standard("gray"));
    public static final AutomobileFrame STANDARD_LIGHT_GRAY = REGISTRY.register(standard("light_gray"));
    public static final AutomobileFrame STANDARD_CYAN = REGISTRY.register(standard("cyan"));
    public static final AutomobileFrame STANDARD_PURPLE = REGISTRY.register(standard("purple"));
    public static final AutomobileFrame STANDARD_BLUE = REGISTRY.register(standard("blue"));
    public static final AutomobileFrame STANDARD_BROWN = REGISTRY.register(standard("brown"));
    public static final AutomobileFrame STANDARD_GREEN = REGISTRY.register(standard("green"));
    public static final AutomobileFrame STANDARD_RED = REGISTRY.register(standard("red"));
    public static final AutomobileFrame STANDARD_BLACK = REGISTRY.register(standard("black"));

    public static final AutomobileFrame RED_TRACTOR = REGISTRY.register(tractor("red"));
    public static final AutomobileFrame YELLOW_TRACTOR = REGISTRY.register(tractor("yellow"));
    public static final AutomobileFrame GREEN_TRACTOR = REGISTRY.register(tractor("green"));
    public static final AutomobileFrame BLUE_TRACTOR = REGISTRY.register(tractor("blue"));

    public static final AutomobileFrame SHOPPING_CART = REGISTRY.register(
            new AutomobileFrame(
                    Automobility.id("shopping_cart"),
                    0.25f,
                    new FrameModel(
                            Automobility.id("textures/entity/automobile/frame/shopping_cart.png"),
                            ShoppingCartFrameModel::new,
                            WheelBase.basic(17, 12),
                            17,
                            11,
                            7,
                            17
                    )
            )
    );

    public static final AutomobileFrame C_ARR = REGISTRY.register(
            new AutomobileFrame(
                    Automobility.id("c_arr"),
                    0.85f,
                    new FrameModel(
                            Automobility.id("textures/entity/automobile/frame/c_arr.png"),
                            CARRFrameModel::new,
                            WheelBase.basic(44.5f, 16),
                            44.5f,
                            6f,
                            19.5f,
                            10.5f
                    )
            )
    );

    public static final AutomobileFrame PINEAPPLE = REGISTRY.register(
            new AutomobileFrame(
                    Automobility.id("pineapple"),
                    0.75f,
                    new FrameModel(
                            Automobility.id("textures/entity/automobile/frame/pineapple.png"),
                            PineappleFrameModel::new,
                            WheelBase.basic(10, 18),
                            12,
                            16,
                            8,
                            6
                    )
            )
    );

    public static final AutomobileFrame DABABY = REGISTRY.register(
            new AutomobileFrame(
                    Automobility.id("dababy"),
                    0.93f,
                    new FrameModel(
                            Automobility.id("textures/entity/automobile/frame/dababy.png"),
                            DaBabyFrameModel::new,
                            WheelBase.basic(40, 8),
                            40,
                            22,
                            13,
                            3
                    )
            )
    );

    private static AutomobileFrame standard(String color) {
        return new AutomobileFrame(
                Automobility.id("standard_"+color),
                0.6f,
                new FrameModel(
                        Automobility.id("textures/entity/automobile/frame/standard_"+color+".png"),
                        StandardFrameModel::new,
                        WheelBase.basic(26, 10),
                        26,
                        5,
                        13,
                        3
                )
        );
    }

    private static AutomobileFrame tractor(String color) {
        return new AutomobileFrame(
                Automobility.id(color+"_tractor"),
                0.9f,
                new FrameModel(
                        Automobility.id("textures/entity/automobile/frame/"+color+"_tractor.png"),
                        TractorFrameModel::new,
                        new WheelBase(
                                new WheelBase.WheelPos(-2, -7, 1.8f, 0, WheelBase.WheelEnd.BACK, WheelBase.WheelSide.LEFT),
                                new WheelBase.WheelPos(-2, 7, 1.8f, 180, WheelBase.WheelEnd.BACK, WheelBase.WheelSide.RIGHT),
                                new WheelBase.WheelPos(15, -1, 1, 0, WheelBase.WheelEnd.FRONT, WheelBase.WheelSide.LEFT),
                                new WheelBase.WheelPos(15, 1, 1, 180, WheelBase.WheelEnd.FRONT, WheelBase.WheelSide.RIGHT)
                        ),
                        20,
                        9,
                        9,
                        8
                )
        );
    }

    @Override
    public Identifier getId() {
        return this.id;
    }

    public String getTranslationKey() {
        return "frame."+id.getNamespace()+"."+id.getPath();
    }

    public static record FrameModel(
            Identifier texture,
            Function<EntityRendererFactory.Context, Model> model,
            WheelBase wheelBase,
            float lengthPx,
            float seatHeight,
            float enginePosBack,
            float enginePosUp
    ) {}
}
