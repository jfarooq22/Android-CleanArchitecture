package com.example.core.domain.repository;

import android.content.SharedPreferences;
import com.example.core.domain.network.NetworkService;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class Repository_Factory implements Factory<Repository> {
  private final Provider<NetworkService> networkServiceProvider;

  private final Provider<SharedPreferences> sharedPreferencesProvider;

  public Repository_Factory(Provider<NetworkService> networkServiceProvider,
      Provider<SharedPreferences> sharedPreferencesProvider) {
    this.networkServiceProvider = networkServiceProvider;
    this.sharedPreferencesProvider = sharedPreferencesProvider;
  }

  @Override
  public Repository get() {
    return newInstance(networkServiceProvider.get(), sharedPreferencesProvider.get());
  }

  public static Repository_Factory create(Provider<NetworkService> networkServiceProvider,
      Provider<SharedPreferences> sharedPreferencesProvider) {
    return new Repository_Factory(networkServiceProvider, sharedPreferencesProvider);
  }

  public static Repository newInstance(NetworkService networkService,
      SharedPreferences sharedPreferences) {
    return new Repository(networkService, sharedPreferences);
  }
}
