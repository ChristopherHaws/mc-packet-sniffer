package io.chaws.packetsniffer.utils;

import io.chaws.packetsniffer.output.OutputSink;
import io.chaws.packetsniffer.output.RawOutputSink;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class PacketCounter {
	private static final OutputSink output = new RawOutputSink();

	public static void add(String string) {
		output.appendLine(string);
	}

	public static void sendPacketCountMessage() {
		var message = output.generateMessage();
		if (message == null) {
			return;
		}

		var mc = MinecraftClient.getInstance();
		if (mc.world == null || !mc.world.isClient) {
			return;
		}

		if (mc.player == null) {
			return;
		}

		mc.player.sendMessage(Text.of(message));
	}
}
