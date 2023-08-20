package raccoonman.reterraforged.common.registries;

import com.mojang.serialization.Codec;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import raccoonman.reterraforged.common.ReTerraForged;
import raccoonman.reterraforged.common.level.levelgen.climate.Climate;
import raccoonman.reterraforged.common.level.levelgen.climate.ClimatePreset;
import raccoonman.reterraforged.common.noise.Noise;
import raccoonman.reterraforged.common.noise.domain.Domain;
import raccoonman.reterraforged.common.noise.func.CurveFunction;
import raccoonman.reterraforged.platform.registries.RegistryUtil;

public final class RTFRegistries {
	public static final ResourceKey<Registry<Codec<? extends Noise>>> NOISE_TYPE = resolve("worldgen/noise_type");
	public static final ResourceKey<Registry<Codec<? extends Domain>>> DOMAIN_TYPE = resolve("worldgen/domain_type");
	public static final ResourceKey<Registry<Codec<? extends CurveFunction>>> CURVE_FUNCTION_TYPE = resolve("worldgen/curve_function_type");
	public static final ResourceKey<Registry<Noise>> NOISE = resolve("worldgen/noise");
	public static final ResourceKey<Registry<Climate>> CLIMATE = resolve("worldgen/climate");
	public static final ResourceKey<Registry<ClimatePreset>> CLIMATE_PRESET = resolve("worldgen/climate_preset");

	public static void register() {
		RegistryUtil.createRegistry(NOISE_TYPE);
		RegistryUtil.createRegistry(DOMAIN_TYPE);
		RegistryUtil.createRegistry(CURVE_FUNCTION_TYPE);
		RegistryUtil.createDataRegistry(NOISE, Noise.DIRECT_CODEC);
		RegistryUtil.createDataRegistry(CLIMATE, Climate.DIRECT_CODEC);
		RegistryUtil.createDataRegistry(CLIMATE_PRESET, ClimatePreset.DIRECT_CODEC);
	}
	
	private static <T> ResourceKey<Registry<T>> resolve(String key) {
		return ResourceKey.createRegistryKey(ReTerraForged.resolve(key));
	}
}
