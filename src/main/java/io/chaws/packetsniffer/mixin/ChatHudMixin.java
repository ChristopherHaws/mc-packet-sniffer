package io.chaws.packetsniffer.mixin;

import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChatHud.class)
public class ChatHudMixin {
	@Inject(method = "getWidth(D)I", at = @At("HEAD"), cancellable = true)
	private static void getWidth(double widthOption, CallbackInfoReturnable<Integer> ci) {
		ci.setReturnValue(MathHelper.floor(widthOption * 480.0 + 40.0));
	}

	@Inject(method = "getHeight(D)I", at = @At("HEAD"), cancellable = true)
	private static void getHeight(double heightOption, CallbackInfoReturnable<Integer> ci) {
		ci.setReturnValue(MathHelper.floor(heightOption * 360.0 + 20.0));
	}
}
