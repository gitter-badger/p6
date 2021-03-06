/*
 * Copyright 2018 lorislab.org.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.lorislab.p6.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.lorislab.jee.jpa.model.PersistentTraceable;

/**
 *
 * @author andrej
 */
@Getter
@Setter
@Entity
@Table(name = "P6_PROCESS_ACTIVITY")
public class ProcessActivity extends PersistentTraceable {

    private static final long serialVersionUID = 3435814346349520798L;

    @Column(name = "TRACE_ID")
    private String traceId;
    
    @Column(name = "PROCESS_INSTANCE_ID")
    private Long processInstanceId;

    @Column(name = "NODE_ID")
    private String nodeId;

    @Column(name = "REQUEST")
    private byte[] request;

    @Column(name = "RESPONSE")
    private byte[] response;
    
    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private ProcessActivityStatus status;
    
    @Column(name = "RETRY")
    private Long retry;
    
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "activity")
    private Set<ProcessActivityError> errors = new HashSet<>();
}
