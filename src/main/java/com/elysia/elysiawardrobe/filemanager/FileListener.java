package com.elysia.elysiawardrobe.filemanager;

import com.elysia.elysiawardrobe.ElysiaWardrobe;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class FileListener {
    private static final long POLL_INTERVAL = TimeUnit.SECONDS.toMillis(1);
    public static void startWatching(File rootDir) {
        FileAlterationObserver observer = new FileAlterationObserver(rootDir);
        observer.addListener(new FileAlterationListenerAdaptor() {
            @Override
            public void onFileChange(File file) {
                if (file.getName().equals("config.yml"))
                    ElysiaWardrobe.getConfigManager().loadConfig();
                ElysiaWardrobe.getInstance().getLogger().info("文件更改: " + file.getName());
            }
        });
        FileAlterationMonitor monitor = new FileAlterationMonitor(POLL_INTERVAL, observer);
        try {
            monitor.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
